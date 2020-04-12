public class Tas {
	// Tableau des sommets
	private int[] tab;
	// Nombre de sommets
	private int n;

	public Tas(int taille){
		tab = new int [taille];
		n=0;
	}

	int pere(int i) {
		return (i-1)/2;
	}

	int gauche(int i) {
		return 2*i+1;
	}

	int droite(int i) {
		return 2*i+2;
	}

	public void inserer(int v) {
		int i = n;
		n++;
		while (i > 1 && tab[pere(i)] <= v) {
			tab[i] = tab[pere(i)] ;
			i = pere(i);}
		tab[i] = v;
	}

	public boolean estUneFeuille(int i) {
		return (2 * i + 1 >= n);
	}

	public boolean aUnFilsDroit(int i) {
		return (2 * i + 2 < n);
	}


	void supprimerMaximum() {
		n--;
		int v = tab[n];
		int i = 0;
		while (!estUneFeuille(i)) {
			int j = gauche(i);
			if (aUnFilsDroit(i) && tab[droite(i)] > tab[gauche(i)])
			j = droite(i);
			if (v >= tab[j])
			break;
			tab[i] = tab[j];
			i = j;
		}
		tab[i] = v;
	}


}
