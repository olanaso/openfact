package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.common.CustomizationIDModel;
import org.openfact.models.ubl.common.IDModel;
import org.openfact.models.ubl.common.IssueDateModel;
import org.openfact.models.ubl.common.NoteModel;
import org.openfact.models.ubl.common.ReferenceDateModel;
import org.openfact.models.ubl.common.SignatureModel;
import org.openfact.models.ubl.common.SupplierPartyModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;
import org.openfact.models.ubl.common.UBLVersionIDModel;
import org.openfact.models.ubl.common.VoidedDocumentsLineModel;

public interface VoidedDocumentsModel {

    UBLExtensionsModel getUBLExtensions();

    void setUBLExtensions(UBLExtensionsModel value);

    UBLVersionIDModel getUBLVersionID();

    void setUBLVersionID(UBLVersionIDModel value);

    CustomizationIDModel getCustomizationID();

    void setCustomizationID(CustomizationIDModel value);

    IDModel getID();

    void setID(IDModel value);

    ReferenceDateModel getReferenceDate();

    void setReferenceDate(ReferenceDateModel value);

    IssueDateModel getIssueDate();

    void setIssueDate(IssueDateModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

    List<SignatureModel> getSignature();

    void setSignature(List<SignatureModel> signature);

    SupplierPartyModel getAccountingSupplierParty();

    void setAccountingSupplierParty(SupplierPartyModel value);

    List<VoidedDocumentsLineModel> getVoidedDocumentsLine();

    void setVoidedDocumentsLine(List<VoidedDocumentsLineModel> voidedDocumentsLine);

    String getId();

    void setId(String value);

}
