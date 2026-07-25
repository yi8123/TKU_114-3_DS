public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        // 測試空串列播放
        playlist.playAll();

        // 新增歌曲測試
        playlist.append("S001", "Song A");
        playlist.append("S002", "Song B");
        playlist.append("S003", "Song C");
        playlist.append("S004", "Song D");
        
        // 測試重複代碼阻擋
        playlist.append("S002", "Duplicate Song"); 

        playlist.playAll();

        // 測試搜尋
        String found = playlist.search("S003");
        System.out.println("搜尋 S003 結果: " + (found != null ? found : "找不到"));
        System.out.println("搜尋 S999 結果: " + (playlist.search("S999") != null ? playlist.search("S999") : "找不到"));

        // 測試刪除第一首
        playlist.remove("S001");
        playlist.playAll();

        // 測試刪除最後一首
        playlist.remove("S004");
        playlist.playAll();

        // 測試找不到資料的刪除
        playlist.remove("S999");
    }
}