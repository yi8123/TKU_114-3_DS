public class PlaylistNode {
    String songCode; // 歌曲代碼（不可重複）
    String songName; // 歌曲名稱
    PlaylistNode next;

    public PlaylistNode(String songCode, String songName) {
        this.songCode = songCode;
        this.songName = songName;
        this.next = null;
    }
}