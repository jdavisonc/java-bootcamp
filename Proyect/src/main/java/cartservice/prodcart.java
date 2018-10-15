package cartservice;

public class prodcart {
	private int iduser;
	private int idprod;
	public prodcart(int iduser, int idprod) {
		this.iduser = iduser;
		this.idprod = idprod;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getIdprod() {
		return idprod;
	}
	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}
}
