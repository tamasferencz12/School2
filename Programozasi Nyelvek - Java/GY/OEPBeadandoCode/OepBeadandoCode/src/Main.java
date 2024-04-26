
public class Main {
    public static void main() {
        class Allat {
            String faj;

            public Allat(String faj) {
                this.faj = faj;
            }

            public String getFaj() {
                return faj;
            }

            @Override
            public String toString() {
                return "Allat{" +
                        "osztaly='" + this.getClass().getSimpleName() + "'" +
                        ",faj='" + faj + '\'' +
                        '}';
            }
        }

        class Ragadozok extends Allat {
            public Ragadozok() {
                super("Ragadozok");
            }

            public void Tamadas(Zsakmanyallat zsakmanyallat) {

            }
        }

        class Zsakmanyallat extends Allat {
            public Zsakmanyallat() {
                super("Zsakmanyallat");
            }
        }

        class Lemming extends Zsakmanyallat {
        }

        class Sarkinyul extends Zsakmanyallat {
        }

        class Jegesmedve extends Ragadozok {
        }


        class AllatKolonia {
            Class<? extends Allat> allatClass;
            String becenev;
            int letszam;

            public AllatKolonia(Class<? extends Allat> allatClass, String becenev, int letszam) {
                this.allatClass = allatClass;
                this.becenev = becenev;
                this.letszam = letszam;
            }

            @Override
            public String toString() {
                return "Kolonia{" +
                        "allatClass=" + allatClass +
                        ", becenev='" + becenev + '\'' +
                        ", letszam=" + letszam +
                        '}';
            }
        }

        class RagadozoKolonia extends AllatKolonia {

            public RagadozoKolonia(Class<? extends Ragadozok> allatClass, String becenev, int letszam) {
                super(allatClass, becenev, letszam);
            }

            public void tamadas(ZsakmanyallatKolonia zsakmanyallatKolonia) {
                System.out.println(becenev + " " + allatClass.getClass().getSimpleName()
                        + " tamadjak a " + zsakmanyallatKolonia.becenev + " " + zsakmanyallatKolonia.allatClass.getSimpleName() + ", letszam " + zsakmanyallatKolonia.letszam);

            }
        }

        class ZsakmanyallatKolonia extends AllatKolonia {

            public ZsakmanyallatKolonia(Class<? extends Zsakmanyallat> allatClass, String becenev, int letszam) {
                super(allatClass, becenev, letszam);
            }
        }


        public void test1() {
            Allat j = new Jegesmedve();
            System.out.println(j);
            Allat n = new Sarkinyul();
            System.out.println(n);


            RagadozoKolonia medvek1 = new RagadozoKolonia(Jegesmedve.class, "sovany macik", 10);
            System.out.println(medvek1);
            RagadozoKolonia medvek2 = new RagadozoKolonia(Jegesmedve.class, "kover macik", 100);
            System.out.println(medvek2);

            ZsakmanyallatKolonia nyuszik = new ZsakmanyallatKolonia(Sarkinyul.class, "nyuszik", 10);
            System.out.println(nyuszik);
            ZsakmanyallatKolonia lemmingek = new ZsakmanyallatKolonia(Lemming.class, "lemmingek", 34);
            System.out.println(lemmingek);


            medvek1.tamadas(nyuszik);
            medvek2.tamadas(lemmingek);


        }
    }
}