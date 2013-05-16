package common;

import java.io.Serializable;

public class WebBrowserRecord implements Serializable, Comparable<WebBrowserRecord>{
	
	private String name,creator,cost, license,layoutEngine;
	

	public WebBrowserRecord(){
		
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCreator() {
		return creator;
	}


	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public String getLayoutEngine() {
		return layoutEngine;
	}


	public void setLayoutEngine(String layoutEngine) {
		this.layoutEngine = layoutEngine;
	}


	
	
	public double similarityTo(WebBrowserRecord other){
		double out = 0.0;
		if(this.name != null && this.name.equals(other.name)){
			out += 1;
		}
		if(this.creator != null && this.creator.equals(other.creator)){
			out += 1;
		}
		if(this.cost != null && this.cost.equals(other.cost)){
			out += 1;
		}
		if(this.license != null && this.license.equals(other.license)){
			out += 1;
		}
		if(this.layoutEngine != null && this.layoutEngine.equals(other.layoutEngine)){
			out += 1;
		}
		return out / 5.0;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result
				+ ((layoutEngine == null) ? 0 : layoutEngine.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebBrowserRecord other = (WebBrowserRecord) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (layoutEngine == null) {
			if (other.layoutEngine != null)
				return false;
		} else if (!layoutEngine.equals(other.layoutEngine))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return String.format("|\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|", name,creator,cost,license,layoutEngine);
	}


	@Override
	public int compareTo(WebBrowserRecord other) {
		return this.name.compareTo(other.name);
		
	}
	
	
}
