package hr.fer.zemris.java.tecaj.hw1;

/**
 * ProgramListe class is implementation of a singly linked list. Command line
 * arguments are not used for this class.
 * 
 * @author TheKarlo95
 * @version 1.0
 */
class ProgramListe {

    /**
     * Implementation of a node of singly linked list.
     * 
     * @author TheKarlo95
     * @version 1.0
     */
    static class CvorListe {
        /** Next node of the list. */
        CvorListe sljedeci;
        /** Data contained in this node. */
        String podatak;
    }

    /**
     * Starting point of a program.
     * 
     * @param args
     *            Command line argument. Not used for this class.
     */
    public static void main(String[] args) {
        CvorListe cvor = null;

        cvor = ubaci(cvor, "Jasna");
        cvor = ubaci(cvor, "Ana");
        cvor = ubaci(cvor, "Ivana");

        System.out.println("Ispisujem listu uz originalni poredak:");
        ispisiListu(cvor);

        cvor = sortirajListu(cvor);
        System.out.println("Ispisujem listu nakon sortiranja:");
        ispisiListu(cvor);

        int vel = velicinaListe(cvor);
        System.out.println("Lista sadrzi elemenata: " + vel);

    }

    /**
     * Calculates the size of a list
     * 
     * @param cvor
     *            Node of a list from which counting the size begins.
     * @return Size of a list
     */
    private static int velicinaListe(CvorListe cvor) {
        int size = 0;

        for (; cvor != null; cvor = cvor.sljedeci)
            size++;

        return size;
    }

    /**
     * Adds a node to the last position of a list.
     * 
     * @param prvi
     *            First node
     * @param podatak
     *            Data to be saved in a list
     * @return First node
     */
    private static CvorListe ubaci(CvorListe prvi, String podatak) {
        if (prvi == null) {
            prvi = new CvorListe();
            prvi.podatak = podatak;
            return prvi;
        }

        CvorListe cvor = prvi;

        while (cvor.sljedeci != null)
            cvor = cvor.sljedeci;

        CvorListe novi = new CvorListe();
        novi.podatak = podatak;

        cvor.sljedeci = novi;

        return prvi;
    }

    /**
     * Printing out a list. Every node is in a different line.
     * 
     * @param cvor
     *            First node of a list
     */
    private static void ispisiListu(CvorListe cvor) {
        CvorListe prvi = cvor;

        for (; cvor != null; cvor = cvor.sljedeci)
            System.out.println(cvor.podatak);

        cvor = prvi;
    }

    /**
     * Inversely lexicographically sorts the list using "bubble sort" algorithm.
     * 
     * @param cvor
     *            First node of a list
     * @return First node of a list
     */
    private static CvorListe sortirajListu(CvorListe cvor) {
        if (velicinaListe(cvor) < 2)
            return cvor;

        CvorListe prvi = cvor;
        boolean sorted;
        String tmp;

        do {
            sorted = true;

            for (cvor = prvi; cvor != null; cvor = cvor.sljedeci) {
                if (cvor.sljedeci != null
                        && cvor.podatak.compareTo(cvor.sljedeci.podatak) > 0) {
                    tmp = cvor.podatak;
                    cvor.podatak = cvor.sljedeci.podatak;
                    cvor.sljedeci.podatak = tmp;

                    sorted = false;
                }
            }
        } while (!sorted);

        return prvi;
    }
}
