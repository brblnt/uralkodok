package uralkodok;

/**
 *
 * @author Bor Balint
 */
public class Uralkodo {
    private int uralkodasKezdete;
    private int uralkodasVege;
    private String nev;
    private String koronazasHely;

    public Uralkodo(String sor) {
        String[] darabok = sor.split(";");
        try {
            if(!darabok[0].isEmpty())
                this.uralkodasKezdete = Integer.parseInt(darabok[0]);
            if(!darabok[1].isEmpty())
                this.uralkodasVege = Integer.parseInt(darabok[1]);
            
        } catch (NumberFormatException e) {
            System.out.println("Hiba: "+e);
        }
        this.nev = darabok[2];
        //System.out.println(darabok.length);
        if(darabok.length > 3){
            this.koronazasHely = darabok[3];
        }
        else{
            this.koronazasHely = "";
        }
    }

    @Override
    public String toString() {
        return "Uralkodo{" + "uralkodasKezdete=" + uralkodasKezdete + ", uralkodasVege=" + uralkodasVege + ", nev=" + nev + ", koronazasHely=" + koronazasHely + '}';
    }
    
    public int getUralkodasKezdete() {
        return uralkodasKezdete;
    }

    public void setUralkodasKezdete(int uralkodasKezdete) {
        this.uralkodasKezdete = uralkodasKezdete;
    }

    public int getUralkodasVege() {
        return uralkodasVege;
    }

    public void setUralkodasVege(int uralkodasVege) {
        this.uralkodasVege = uralkodasVege;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getKoronazasHely() {
        return koronazasHely;
    }

    public void setKoronazasHely(String koronazasHely) {
        this.koronazasHely = koronazasHely;
    }
    
}
