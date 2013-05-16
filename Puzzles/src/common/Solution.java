package common;

import java.io.File;
import java.util.List;

public abstract class Solution {
	
	protected String contractorId;
	
	protected Solution(String contractorId){
		this.contractorId = contractorId;
	}
	

	public String getContractorId() {
		return contractorId;
	}
	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}
	
	public abstract List<WebBrowserRecord> runSolution(File inputFile);
	
	

}
