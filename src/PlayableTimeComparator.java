import java.util.*;
public class PlayableTimeComparator implements Comparator<Playable> {

	@Override
	public int compare(Playable a, Playable b) {
		if (a.getPlayTimeSeconds() < b.getPlayTimeSeconds()) {
			return -1;
		}
		else if (a.getPlayTimeSeconds() > b.getPlayTimeSeconds()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
