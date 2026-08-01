# 系統架構設計與演算法選型說明書

本說明書針對系統中的核心功能，詳細論述所選用的資料結構與演算法之設計考量與決策原因。

## 1. 完整主資料庫庫存管理 (Master Data Storage)
* **實作對應檔案**: `LibraryManagementSystem.java`
* **對應 Method 名稱**: `registerBook(Book book)`
* **採用技術**: `ArrayList`
* **選擇原因**: 主資料庫需要高頻率的走查、隨機讀取以及動態容量調整。`ArrayList` 底層基於連續陣列，能在 $O(1)$ 時間內提供隨機訪問，對後續要轉換成一般陣列送進 `Merge Sort` 排序極為親和。
* **未採用另一方法原因**: 未採用 `LinkedList`。因為 `LinkedList` 在進行演算法走查與遍歷時，由於內部節點記憶體分散，會導致 CPU 快取命中率降低，且不支援隨機訪問，每次查詢都需要從頭 $O(n)$ 移動指針。

## 2. 維修排程等待佇列 (Reschedule Management)
* **實作對應檔案**: `RepairSchedulingSystem.java`
* **對應 Method 名稱**: `rescheduleQueue()`
* **採用技術**: `Queue (LinkedList)`
* **選擇原因**: 維修工作嚴格遵循「先登記先處理」的業務邏輯，屬於典型先進先出（FIFO）模型。`Queue` 的 `offer()` 和 `poll()` 操作可以在恆定時間 $O(1)$ 內完成，語意清晰。
* **未採用另一方法原因**: 未採用 `Stack`。`Stack` 是後進先出（LIFO）結構，如果用於等待排程，會導致先到的維修單被不斷壓在底部，造成「飢餓現象（Starvation）」，嚴重違反公平性原則。

## 3. 取消復原機制 (Undo Mechanism)
* **實作對應檔案**: `EventRegistrationSystem.java`
* **對應 Method 名稱**: `rollbackCancellation()`
* **採用技術**: `Stack`
* **選擇原因**: 復原功能要求取得「最近一次」被刪除的資料，完全契合後進先出（LIFO）的特點。透過 `push()` 存入與 `pop()` 取出，皆能在 $O(1)$ 時間內達成。
* **未採用另一方法原因**: 未採用 `Queue`。若採用 `Queue`，執行復原時取出的會是最久以前被取消的資料，而非用戶直覺認知的「上一步撤銷」，不符合復原（Undo）的互動語意。

## 4. 主資料庫快速鍵值精確搜尋 (Fast Key Search)
* **實作對應檔案**: `BookAlgorithms.java`
* **對應 Method 名稱**: `binarySearchById(Book[] arr, String targetId)`
* **採用技術**: `Binary Search`
* **選擇原因**: 當資料庫規模龐大且已經過編號排序時，`Binary Search` 可以將每次比對範圍折半，將時間複雜度降至極低且優異的 $O(\log n)$，非常適合用於主鍵 ID 的秒級檢索。
* **未採用另一方法原因**: 未採用 `Sequential Search`。當主資料量增加至數萬筆時，`Sequential Search` 的平均時間複雜度為 $O(n)$，會造成嚴重的線性掃描效能瓶頸。

## 5. 模糊或多重非主鍵篩選 (Non-key Filter)
* **實作對應檔案**: `BookAlgorithms.java`
* **對應 Method 名稱**: `sequentialSearchByCategory(ArrayList<Book> list, String category)`
* **採用技術**: `Sequential Search`
* **選擇原因**: 書籍的「分類（Category）」並不是唯一鍵值，且主資料並非以分類作為排序依據。在資料未排序且可能存在多筆相同結果的狀況下，必須進行全表掃描（線性走查），確保不遺漏任何一筆相符的資料。
* **未採用另一方法原因**: 未採用 `Binary Search`。因為 `Binary Search` 的先決條件是資料必須「已排序」，且其只能有效搜尋單一特定元素，不適用於非排序區間的多重目標匹配。

## 6. 多欄位權重高效排序 (Stable Dynamic Sort)
* **實作對應檔案**: `RepairAlgorithms.java`
* **對應 Method 名稱**: `sortByPriorityDesc(RepairTask[] arr, int left, int right)`
* **採用技術**: `Merge Sort`
* **選擇原因**: 系統要求當維修工作的「優先權相同時，必須維持原有登記順序」。`Merge Sort` 屬於典型的「穩定排序（Stable Sort）」，且擁有保證 $O(n \log n)$ 的優異最差時間複雜度，能避免大數據下的效能崩潰。
* **未採用另一方法原因**: 未採用 `Selection Sort`。`Selection Sort` 的時間複雜度固定為不理想的 O(n²)，且在進行元素交換時會直接破壞相同權重元素的相對順序，屬於「不穩定排序」，無法滿足業務需求。