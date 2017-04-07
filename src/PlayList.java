import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//Tiffany Vinci-Cannava tv2bq CS2110 Lab Section 3
//Collaborated with Taji tah7qd

public class PlayList implements Playable {
	private String name;
	private  ArrayList<Playable> playableList;
	private Song s;

	public PlayList() {
		playableList = new ArrayList<Playable>();
		this.name = "Untitled";
	}

	public PlayList(String newname) {
		playableList = new ArrayList<Playable>();
		this.name = newname;
	}

	public boolean loadSongs(String filename) {
		/** Loads songs in file with given name. */
		ArrayList<Song> a = new ArrayList<Song>();
		File f = new File(filename);
		Scanner read;
		try {
			read = new Scanner(f);

			String[] time = new String[2];
			while (read.hasNextLine()) {
				//songs = read.nextLine();
				String songName = read.nextLine().trim();
				String songArtist = read.nextLine().trim();
				String songLength = read.nextLine().trim();
				time = songLength.split(":");
				int minutes = Integer.parseInt(time[0]);
				int seconds = Integer.parseInt(time[1]);
				String ignore = read.nextLine().trim();
				Song b = new Song(songArtist, songName, minutes, seconds);
				this.playableList.add(b);
				return true;
			}
			//	return songs.length() > 0;
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean clear() {
		/** returns true if all songs removed, returns false otherwise. */
		if (playableList.size() > 0) {
			playableList.clear();
			return true;
		} else {
			return false;
		}
	}

	public boolean addPlayList(PlayList pl) {
		/** returns true if song is initially not in arrayList, then added. */
		for (Playable p : playableList) {
			if ((p.getName().equals(pl.getName()))) {
				return false;
			}
		} 
		playableList.add(pl); // add song to last position...
		return true;

	}

	public boolean addSong(Song j) {
		if (playableList.contains(j)) {
			return false;
		}
		else {
			playableList.add(j);
			return true;
		}
	}

	public Playable removePlayable(int index) {
		Playable c = null;
		if (index <= playableList.size() - 1 && index >= 0) {
			c = playableList.get(index);
			playableList.remove(c);
			return c;
		}
		// else if(index==playableList.size()){
		// c=playableList.get(index-1);
		// playableList.remove(c);
		// return c;
		// }
		else {
			return null;
		}
	}

	public Playable removePlayable(Playable p) {
		for (int i = 0; i < playableList.size(); i++) {
			if (playableList.get(i).equals(p)) {
				playableList.remove(p);
			}
		}
		return p;
	}

	public Playable getPlayable(int index) {
		if (index >= 0 && index < playableList.size()) {
			return playableList.get(index);
		} else {
			return null;
		}
	}

	public void play() {
		for (int i = 0; i < playableList.size(); i++) {
			playableList.get(i).play();
		}
	}

	public int size() {
		return playableList.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void sortByTime() {
		Collections.sort(playableList, new PlayableTimeComparator());
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	public void sortByName() {
		Collections.sort(playableList, new PlayableNameComparator());
	}

	@Override
	public String toString() {
		return "playableList [name=" + name + ", playableList=" + playableList
				+ "]";
	}

	public static void main(String[] args) throws FileNotFoundException {
		PlayList a = new PlayList();
		System.out.println(a.loadSongs("basic.txt"));
	}
	@Override
	public int getPlayTimeSeconds() {
		int getSec = 0;

		for (int i = 0 ; i < playableList.size() ; i++) {		
			getSec += playableList.get(i).getPlayTimeSeconds();
		}
		return getSec;
	}
}