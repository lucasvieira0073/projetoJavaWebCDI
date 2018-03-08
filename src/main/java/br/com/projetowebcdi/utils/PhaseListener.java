package br.com.projetowebcdi.utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

public class PhaseListener implements javax.faces.event.PhaseListener {

	private static final long serialVersionUID = 4960985963395841270L;

	public void afterPhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext();

		System.out.println("AFTER: " + event.getPhaseId());
		
	}

	public void beforePhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext();

		System.out.println("BEFORE: " + event.getPhaseId());
		
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	

}
