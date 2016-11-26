package org.openfact.models.jpa.ubl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.DebitNoteSendEventModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.DebitNoteEntity;
import org.openfact.models.jpa.entities.ubl.DebitNoteSendEventEntity;
import org.openfact.models.ubl.DebitNoteModel;

public class DebitNoteSendEventAdapter implements DebitNoteSendEventModel, JpaModel<DebitNoteSendEventEntity> {
	protected static final Logger logger = Logger.getLogger(DebitNoteSendEventAdapter.class);

	protected OrganizationModel organization;
	protected DebitNoteSendEventEntity sendEvent;
	protected EntityManager em;
	protected OpenfactSession session;

	public DebitNoteSendEventAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			DebitNoteSendEventEntity sendEvent) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.sendEvent = sendEvent;
	}

	@Override
	public String getId() {
		return sendEvent.getId();
	}

	@Override
	public String getDocumentId() {
		return sendEvent.getDocumentId();
	}

	@Override
	public boolean getAccepted() {
		return sendEvent.isAccepted();
	}

	@Override
	public String getDescription() {
		return sendEvent.getDescription();
	}

	@Override
	public String getNote() {
		return sendEvent.getNote();
	}

	@Override
	public String getResponseCode() {
		return sendEvent.getResponseCode();
	}

	@Override
	public String getErrorMessage() {
		return sendEvent.getErrorMessage();
	}

	@Override
	public String getDigestValue() {
		return sendEvent.getDigestValue();
	}

	@Override
	public String getBarCode() {
		return sendEvent.getBarCode();
	}

	@Override
	public byte[] getDocumentSubmitted() {
		return sendEvent.getDocumentSubmitted();
	}

	@Override
	public byte[] getDocumentResponse() {
		return sendEvent.getDocumentResponse();
	}

	@Override
	public byte[] getCustomerDocument() {
		return sendEvent.getCustomerDocument();
	}

	@Override
	public Map<String, String> getWarning() {
		return sendEvent.getWarning();
	}

	@Override
	public Map<String, String> getSuccess() {
		return sendEvent.getSuccess();
	}

	@Override
	public void setDocumentId(String documentId) {
		sendEvent.setDocumentId(documentId);
	}

	@Override
	public void setAccepted(boolean accepted) {
		sendEvent.setAccepted(accepted);
	}

	@Override
	public void setDescription(String description) {
		sendEvent.setDescription(description);
	}

	@Override
	public void setNote(String note) {
		sendEvent.setNote(note);
	}

	@Override
	public void setResponseCode(String responseCode) {
		sendEvent.setResponseCode(responseCode);
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		sendEvent.setErrorMessage(errorMessage);
	}

	@Override
	public void setDigestValue(String digestValue) {
		sendEvent.setDigestValue(digestValue);
	}

	@Override
	public void setBarCode(String barCode) {
		sendEvent.setBarCode(barCode);
	}

	@Override
	public void setDocumentSubmitted(byte[] documentSubmitted) {
		sendEvent.setDocumentSubmitted(documentSubmitted);
	}

	@Override
	public void setDocumentResponse(byte[] documentResponse) {
		sendEvent.setDocumentResponse(documentResponse);
	}

	@Override
	public void setCustomerDocument(byte[] customerDocument) {
		sendEvent.setCustomerDocument(customerDocument);
	}

	@Override
	public void setWarning(Map<String, String> warning) {
		sendEvent.setWarning(warning);
	}

	@Override
	public void setSuccess(Map<String, String> success) {
		sendEvent.setSuccess(success);
	}

	@Override
	public DebitNoteSendEventEntity getEntity() {
		return sendEvent;
	}

	@Override
	public List<DebitNoteModel> getDebitNotes() {
		return sendEvent.getDebitNotes().stream().map(f -> new DebitNoteAdapter(session, organization, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoices(List<DebitNoteModel> debitNotes) {
		List<DebitNoteEntity> entities = debitNotes.stream().map(f -> DebitNoteAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		sendEvent.setDebitNotes(entities);

	}

}