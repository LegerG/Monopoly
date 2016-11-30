package Modele;

import Modele.Carreau;
import java.util.ArrayList;

public class Joueur {
	private String _nomJoueur;
	private int _cash = 1500;
	private ArrayList<Compagnie> _compagnies = new ArrayList<Compagnie>();
	private ArrayList<ProprieteAConstruire> _proprietesAConstruires = new ArrayList<ProprieteAConstruire>();
	private ArrayList<Gare> _gares = new ArrayList<Gare>();
	private Carreau _positionCourante;

	public void payerLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int aL) {
		throw new UnsupportedOperationException();
	}

	public int getCash() {
		return this._cash;
	}

	public Carreau getPositionCourante() {
		return this._positionCourante;
	}

	public void setPositionCourante(Carreau aCa) {
		throw new UnsupportedOperationException();
	}

    public String getNomJoueur() {
        return _nomJoueur;
    }

    public void setNomJoueur(String _nomJoueur) {
        this._nomJoueur = _nomJoueur;
    }

    public ArrayList<Compagnie> getCompagnies() {
        return _compagnies;
    }

    public void setCompagnies(ArrayList<Compagnie> _compagnies) {
        this._compagnies = _compagnies;
    }

    public ArrayList<ProprieteAConstruire> getProprietesAConstruires() {
        return _proprietesAConstruires;
    }

    public void setProprietesAConstruires(ArrayList<ProprieteAConstruire> _proprietesAConstruires) {
        this._proprietesAConstruires = _proprietesAConstruires;
    }

    public ArrayList<Gare> getGares() {
        return _gares;
    }

    public void setGares(ArrayList<Gare> _gares) {
        this._gares = _gares;
    }
        
        
}