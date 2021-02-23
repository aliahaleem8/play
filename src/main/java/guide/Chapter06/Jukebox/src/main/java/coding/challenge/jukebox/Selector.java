package guide.Chapter06.Jukebox.src.main.java.coding.challenge.jukebox;
 
public interface Selector {
    
    public void nextSongBtn();
    public void prevSongBtn();
    public void addSongToPlaylistBtn(Song song);
    public void removeSongFromPlaylistBtn(Song song);
    public void shuffleBtn();
}
