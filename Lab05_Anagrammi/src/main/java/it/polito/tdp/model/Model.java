package it.polito.tdp.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammiDAO.AnagrammaDAO;

public class Model {
 
	AnagrammaDAO anagrammaDao= new AnagrammaDAO();
	
	/** Il metodo si occupa di preparare la ricorsione per ottenere il Set di anagrammi
	 * @param parola - parola di cui trovare gli anagrammi
	 * @return - Set contente gli anagrammi
	 * **/
	
	public Set<String> calcolaAnagrammi(String parola){
		Set <String> anagrammi = new HashSet<String>();
        String parziale = "";
        //Avvio ricorsione
        calcola(parziale, parola, 0, anagrammi);
        return anagrammi;
        
	}
	
	public boolean isCorrect(String anagramma) {
		return anagrammaDao.isCorrect(anagramma);
	}
	
	/**
	 * Il metodo si occupa di compiere la ricorsione
	 * @param parziale - soluzione parziale
	 * @param parola - parola iniziale di cui si vogliono calcolare gli anagrammi
	 * @param livello - il livello della ricorsione
	 * @param anagrammi - Il Set in cui si aggiungono i risultati
	 */
	
	private void calcola(String parziale, String parola, int livello, Set <String> anagrammi) {
		//A Condizione di terminazione
		if(livello == parola.length()) {
			//parziale è una soluzione completa
			anagrammi.add(parziale);
			return;
		}
		//B Genera una soluzione parziale
		for(int i=0 ; i<parola.length(); i++) {
			//C Filtro di validità della soluzione parziale
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))) {
				parziale += parola.charAt(i);
			    calcola(parziale, parola, livello+1, anagrammi);
				//D Backtracking
			    parziale = parziale.substring(0, parziale.length()-1);
			}
		}
		
		
	}
	
	//permette di trovare il numero di occorrenze di un char 
	//dentro una String !

	private int charCounter(String string, char c) {
		
		int count=0;
	
		for(int i = 0; i<string.length(); i++) {
		
			if(string.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	
}
