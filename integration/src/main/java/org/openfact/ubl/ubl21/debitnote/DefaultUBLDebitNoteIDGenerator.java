package org.openfact.ubl.ubl21.debitnote;

import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.ubl21.qualifiers.UBLDocumentType;
import org.openfact.ubl.ubl21.qualifiers.UBLProviderType;

import javax.ejb.Stateless;

@Stateless
@UBLProviderType("default")
@UBLDocumentType("DEBIT_NOTE")
public class DefaultUBLDebitNoteIDGenerator implements UBLDebitNoteIDGenerator {

    @Override
    public String generateID(OrganizationModel organization, Object o) {
        return OpenfactModelUtils.generateId();
    }

}
