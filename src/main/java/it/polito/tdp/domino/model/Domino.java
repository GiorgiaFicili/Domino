package it.polito.tdp.domino.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Domino {

	List<Tesserina> sequenza;
	
	public List<Integer> sequenzaDomino () {
		
		Set<Tesserina> tesserine = new HashSet<>();
		
		for(int i=1; i<=2; i++) {
			
			for(int j=i; j<=2; j++) {
				
				tesserine.add(new Tesserina(i,j));
				
			}
			
		}
		
		sequenza = new ArrayList<>();
		boolean valida = true;
		
		ricorsione(tesserine, 0, new ArrayList<Tesserina>(), valida);
		
		List<Integer> sequenzaInteri = new ArrayList<>();
		
		for(Tesserina t : sequenza) {
			
			sequenzaInteri.add(t.getCella1());
			sequenzaInteri.add(t.getCella2());
			
		}
		
		return sequenzaInteri;
		
	}
	
	private void ricorsione(Set<Tesserina> tesserine, int livello, List<Tesserina> parziale, boolean valida) {
		
		
		if(!valida || tesserine.size()==0) {
			
			if(parziale.size()>=sequenza.size()) {
				sequenza = new ArrayList<>(parziale);
			}
			
		} else {
		
			for(Tesserina t : tesserine) {
				
				if((livello==0) || (livello!=0 && t.getCella1()==parziale.get(parziale.size()-1).getCella2())) {
					
					tesserine.remove(t);
					parziale.add(t);	
					
					valida = true;
					
					ricorsione(tesserine, livello+1, parziale, valida);
					
					parziale.remove(parziale.size()-1);
					
				} else if(livello!=0 && t.getCella2()==parziale.get(parziale.size()-1).getCella2()){
					
					tesserine.remove(t);
					parziale.add(t.reverse());
					
					valida = true;
					
					ricorsione(tesserine, livello+1, parziale, valida);
					
					parziale.remove(parziale.size()-1);
				
				} else { //caso di non validità
					
					valida = false;
					
					ricorsione(tesserine, livello+1, parziale, valida);
					
				}
				
				
			}
			
		}
		
		
	}

}
	

	
	
