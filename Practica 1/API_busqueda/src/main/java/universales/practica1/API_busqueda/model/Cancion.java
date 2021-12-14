package universales.practica1.API_busqueda.model;

//import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/*@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, 
	getterVisibility=JsonAutoDetect.Visibility.NONE, 
	setterVisibility=JsonAutoDetect.Visibility.NONE, 
	creatorVisibility=JsonAutoDetect.Visibility.NONE)*/
@JsonIgnoreProperties(ignoreUnknown = true)

public class Cancion {

	public String wrapperType;
	private String artistName; 
	private String trackName;
	private String trackPrice;
	private String releaseDate;
	private String primaryGenreName;
	
	public String getWrapperType() {
		return wrapperType;
	}
	public void setWrapperType(String wrapperType) {
		this.wrapperType = wrapperType;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getTrackPrice() {
		return trackPrice;
	}
	public void setTrackPrice(String trackPrice) {
		this.trackPrice = trackPrice;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPrimaryGenreName() {
		return primaryGenreName;
	}
	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}
	
	@Override
	public String toString() {
		return "Cancion [wrapperType=" + wrapperType + ", artistName=" + artistName + ", trackName=" + trackName
				+ ", trackPrice=" + trackPrice + ", releaseDate=" + releaseDate + ", primaryGenreName="
				+ primaryGenreName + "]";
	}
	

}
