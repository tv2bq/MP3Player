import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mp3Player {
	private static ArrayList<PlayList> p;
	private static PlayList z;
	public static void main(String[] args) {
	}
	public Mp3Player() {
		z = new PlayList("Main PlayList");
		this.p = p;
	}
	public static void start() throws FileNotFoundException {
		PlayList a = new PlayList("Main PlayList");
		Scanner key = new Scanner(System.in);
		System.out.println("Enter a filename:");
		String fileName = key.nextLine();
		File f = new File(fileName); 
		if (!(f.exists() && !f.isDirectory())) {
			System.out.println("Enter a filename that exists:");	
		}		
		a.loadSongs(fileName);
		p.add(a);
		//		Scanner s = new Scanner(f);
		//		ArrayList<String> list = new ArrayList<String>();
		//		while(s.hasNext()){
		//			list.add(s.next());
		//		}
		//		s.close();
		//		ArrayList<Playable> play = new ArrayList<Playable>();
		//		play.add((Playable) list);
		//		p.PlayList.setPlayList="";
		//Received assistance from this page: http://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist
	}
	public PlayList getDefaultPlayList() {
		return z;
	}
	public ArrayList getPlayLists() {
		return p;
	}
}
//import java.util.ArrayList;
////Tiffany Vinci-Cannava, tv2bq, partnered with Taji, tah7qd
//public class Mp3Player {
//	ArrayList<PlayList> mp3List;
//	PlayList mainPlaylist;
//	public Mp3Player() {
//		mp3List = new ArrayList<PlayList>();
//		this.mainPlaylist = new PlayList();
//		mp3List.add(this.mainPlaylist);
//	}
//
//	public PlayList getDefaultPlayList() {
//		return this.mainPlaylist;
//
//	}
//	
//	public ArrayList<PlayList>  getPlayLists(){
//		return this.mp3List;
//	}
//
//	public static void main(String[] args) {
//		
//
//	}
//
//}
