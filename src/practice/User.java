package practice;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.print.attribute.standard.Chromaticity;

import com.sun.nio.sctp.PeerAddressChangeNotification.AddressChangeEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private String email;
	private Address address;
	
	private String phone;
	private String webSite;
	private Company company;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", webSite=" + webSite + ", company=" + company + "]";
	}

	public class Address{
		private String streetString;
		private String suite;
		private String city;
		private String zipcode;
		private Geo geo;
		@Override
		public String toString() {
			return "Address [streetString=" + streetString + ", suite=" + suite + ", city=" + city + ", zipcode="
					+ zipcode + ", geo=" + geo + "]";
		}
	}
	
	public class Geo{
		private double lat;
		private double lng;
		@Override
		public String toString() {
			return "Geo [lat=" + lat + ", lng=" + lng + "]";
		}
		
	}
	
	public class Company{
		private String name;
		private String catchPhrase;
		private String bs;
		@Override
		public String toString() {
			return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
		}
		
	}
}
