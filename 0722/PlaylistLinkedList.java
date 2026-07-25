public class PlaylistLinkedList {
    private PlaylistNode head = null;

    // 支援尾端新增 (檢查代碼不可重複)
    public void append(String songCode, String songName) {
        if (containsCode(songCode)) {
            System.out.println("錯誤：歌曲代碼 [" + songCode + "] 已存在，不可重複加入！");
            return;
        }
        
        PlaylistNode newNode = new PlaylistNode(songCode, songName);
        if (head == null) {
            head = newNode;
            return;
        }
        PlaylistNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // 依代碼搜尋是否存在
    private boolean containsCode(String songCode) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.songCode.equals(songCode)) return true;
            current = current.next;
        }
        return false;
    }

    // 依代碼搜尋並回傳歌曲名稱
    public String search(String songCode) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.songCode.equals(songCode)) return current.songName;
            current = current.next;
        }
        return null; // 找不到資料處理
    }

    // 刪除歌曲 (支援第一首與最後一首的正確刪除)
    public void remove(String songCode) {
        if (head == null) {
            System.out.println("播放清單為空，無法刪除。");
            return;
        }

        // 刪除第一首 (Head)
        if (head.songCode.equals(songCode)) {
            System.out.println("已移出播放清單 (第一首): " + head.songName);
            head = head.next;
            return;
        }

        PlaylistNode current = head;
        PlaylistNode prev = null;
        while (current != null && !current.songCode.equals(songCode)) {
            prev = current;
            current = current.next;
        }

        // 找不到資料
        if (current == null) {
            System.out.println("找不到代碼為 [" + songCode + "] 的歌曲，無法刪除。");
            return;
        }

        // 刪除中間或最後一首
        prev.next = current.next;
        System.out.println("已移出播放清單: " + current.songName);
    }

    // 輸出完整播放順序
    public void playAll() {
        if (head == null) {
            System.out.println("【播放清單目前為空】");
            return;
        }
        System.out.println("--- 目前播放順序 ---");
        PlaylistNode current = head;
        int track = 1;
        while (current != null) {
            System.out.println("Track " + track + ". [" + current.songCode + "] " + current.songName);
            track++;
            current = current.next;
        }
        System.out.println("--------------------");
    }
}