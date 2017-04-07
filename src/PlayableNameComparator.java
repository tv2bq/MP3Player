import java.util.Comparator;
public class PlayableNameComparator implements Comparator<Playable> {

	@Override
	public int compare(Playable a, Playable b) {
		return a.getName().compareTo(b.getName());
	}
	
}
