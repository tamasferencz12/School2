using Classes;

namespace BeadandoTests;

public class Tests
{
    [Test]
    public void KoloniaConstructorTest()
    {
        Tundra tundra = new Tundra(1);
        Allat jeges = new Jegesmedve();
        Kolonia kolonia = new Kolonia("kolonia", 100, jeges, tundra);

        Assert.That(kolonia.AllatSG.GetType(), Is.EqualTo(new Jegesmedve().GetType()));
        Assert.That(kolonia.Letszam, Is.EqualTo(100));

        Tundra tundra1 = new Tundra(1);
        Allat medve = new Jegesmedve();
        int szam = 200;
        string nev = "kolonia1";

        Kolonia kolonia1 = new Kolonia(nev, szam, medve, tundra1);

        szam = 50;
        nev = "akarmi";

        Assert.That(kolonia1.Becenev, Is.EqualTo("kolonia1"));
        Assert.That(kolonia1.Letszam, Is.EqualTo(200));
    }

    [Test]
    public void TundraConstructorTest()
    {
        Tundra tundra = new Tundra(1);

        Assert.That(tundra.Kor, Is.EqualTo(1));

        int szam = 200;
        Tundra tundra1 = new Tundra(szam);
        szam = 10;

        Assert.That(tundra1.Kor, Is.EqualTo(200));
    }

    [Test]
    public void AllatConstructorTest()
    {
        Allat allat1 = new Hobagoly();
        Allat allat2 = new Sarkiroka();
        Allat allat3 = new Jegesmedve();
        Allat allat4 = new Lemming();
        Allat allat5 = new Sarkinyul();
        Allat allat6 = new Javorszarvas();

        Assert.That(allat1.GetType(), Is.EqualTo(new Hobagoly().GetType()));
        Assert.That(allat2.GetType(), Is.EqualTo(new Sarkiroka().GetType()));
        Assert.That(allat3.GetType(), Is.EqualTo(new Jegesmedve().GetType()));
        Assert.That(allat4.GetType(), Is.EqualTo(new Lemming().GetType()));
        Assert.That(allat5.GetType(), Is.EqualTo(new Sarkinyul().GetType()));
        Assert.That(allat6.GetType(), Is.EqualTo(new Javorszarvas().GetType()));
    }

    [Test]
    public void RagadozoConstructorTest()
    {
        Ragadozo ragadozo1 = new Jegesmedve();
        Ragadozo ragadozo2 = new Sarkiroka();
        Ragadozo ragadozo3 = new Hobagoly();

        Assert.That(ragadozo1.GetType(), Is.EqualTo(new Jegesmedve().GetType()));
        Assert.That(ragadozo2.GetType(), Is.EqualTo(new Sarkiroka().GetType()));
        Assert.That(ragadozo3.GetType(), Is.EqualTo(new Hobagoly().GetType()));
    }

    [Test]
    public void ZsakmanyallatConstructorTest()
    {
        Zsakmanyallat zsakmanyallat1 = new Lemming();
        Zsakmanyallat zsakmanyallat2 = new Sarkinyul();
        Zsakmanyallat zsakmanyallat3 = new Javorszarvas();

        Assert.That(zsakmanyallat1.GetType(), Is.EqualTo(new Lemming().GetType()));
        Assert.That(zsakmanyallat2.GetType(), Is.EqualTo(new Sarkinyul().GetType()));
        Assert.That(zsakmanyallat3.GetType(), Is.EqualTo(new Javorszarvas().GetType()));
    }

    [Test]
    public void TamadTest()
    {
        Tundra tundra = new Tundra(1);
        Zsakmanyallat zsakmanyallat = new Sarkinyul();
        string becenev1 = "szaporak";
        int letszam1 = 26;
        Kolonia kolonia1 = new Kolonia(becenev1, letszam1, zsakmanyallat, tundra);
        kolonia1.AllatSG.KoloniaSG = kolonia1;

        Ragadozo ragadozo = new Hobagoly();
        string becenev2 = "tollasak";
        int letszam2 = 6;
        Kolonia kolonia2 = new Kolonia(becenev2, letszam2, ragadozo, tundra);
        kolonia2.AllatSG.KoloniaSG = kolonia2;

        Sarkinyul sarkinyul = (Sarkinyul)kolonia1.AllatSG;
        Hobagoly hobagoly = (Hobagoly)kolonia2.AllatSG;
        sarkinyul.Tamadott(hobagoly);

        Assert.That(kolonia1.Letszam, Is.EqualTo(21));
        Assert.That(kolonia2.Letszam, Is.EqualTo(5));
    }

    [Test]
    public void SzaporodasTest()
    {
        Kolonia kolonia1 = new Kolonia("szaporak", 26, new Sarkinyul(), new Tundra(2));
        kolonia1.AllatSG.KoloniaSG = kolonia1;
        Sarkinyul sarkinyul = (Sarkinyul)kolonia1.AllatSG;
        sarkinyul.Szaporodik();

        Kolonia kolonia2 = new Kolonia("szorgosak", 12, new Jegesmedve(), new Tundra(8));
        kolonia2.AllatSG.KoloniaSG = kolonia2;
        Jegesmedve jegesmedve = (Jegesmedve)kolonia2.AllatSG;
        jegesmedve.Szaporodik();

        Assert.That(kolonia1.Letszam, Is.EqualTo(39));
        Assert.That(kolonia2.Letszam, Is.EqualTo(15));
    }

    [Test]
    public void ElvandorlasTest()
    {
        Kolonia kolonia1 = new Kolonia("szaporak", 100, new Sarkinyul(), new Tundra(1));
        kolonia1.AllatSG.KoloniaSG = kolonia1;
        Sarkinyul sarkinyul = (Sarkinyul)kolonia1.AllatSG;
        sarkinyul.Elvandorol();

        Kolonia kolonia2 = new Kolonia("picik", 200, new Lemming(), new Tundra(1));
        kolonia2.AllatSG.KoloniaSG = kolonia2;
        Lemming lemming = (Lemming)kolonia2.AllatSG;
        lemming.Elvandorol();

        Assert.That(kolonia1.Letszam, Is.EqualTo(20));
        Assert.That(kolonia2.Letszam, Is.EqualTo(30));
    }
}