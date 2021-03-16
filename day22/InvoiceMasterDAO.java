package EYExercise.day22;

import java.util.Set;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invMasterDTO);
	public int deleteInvoice(int invno);
	public int updateInvoice(InvoiceMasterDTO invMasterDTO,int customerNo);
	public InvoiceMasterDTO getInvoiceMaster(int invno);
	public Set<InvoiceMasterDTO> getInvoiceMasterAll();
}