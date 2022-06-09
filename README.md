
# Planering
Ett simpelt tre i rad spel med nätverks connection även en databa som sparar antalet vinster för en specifik användare.

1. Nätverks connection 1 server och 1 client
2. Databas (highscore?, användare?, vinster?)
3. Någon typ av 2 spelar spel (tre i rad?, n i rad?)
4. View (java swing?, ascii i terminal?)

- v.19 Nätverks connection med server och client 
- v.20 Spel som körs på servern och client får i sin tur skicka information till servern (kordinaten för vilken plats som valts).
- v.21 En view för spelet (java swing) som körs på både client och server.
- v.22 En databas connection för att spara mängden vinster för en användare (lösenordsskyddat?).


# Post mortem

Isak Thyrel , 2022-06-09

## Inledning

Arbetets syfte var att skapa något typ av program med nätverks koppling även att göra det på en objektorienterat sätt. 
Mitt arbetssätt var att jag skapade en planering som jag följde, jag gjorde detta på ett objektorienterat sätt så att jag kan bygga upp mitt program med tydlig struktur. 
Jag använde mig även av MVC modellen och skapade en modell och controller, en view blev det inte eftersom terminal funkade lika bra, hade dock kunnat använda mig av java swing.

## Bakgrund

Det jag gjorde var att skapa ett tre i rad spel med nätverks koppling. Jag började med att skapa den själva nätverks kopplingen, alltså mellan server och client. 
Detta med hjälp av sockets och serversockets. Jag skapade server classen utifrån client eftersom det var tänkt att servern skulle bygga på clienten.
Nätverkskopplingen bestod av ett program som väldigt mycket liknar ett chatprogram där server och client både lyssnar på varandra hela tiden medans de kan skicka information.
Efter nätverkskopplingen var skapade började jag med själva tre i rad spelet och i början var den helt local.
Då både spel och nätverksdelarna var skapade försökte jag sätta ihop dem. Detta gick dock inte riktigt som jag hade tänkt mig och i efterhand inser jag att detta är på grund av att jag skulle skapat nätverksdelarna efter själva spelet, då de liknade ett chattprogram för mycket.
Jag skulle alltså ha skapat nätverksdelen utan en listenerthread. 

## Positiva erfarenheter

Strukturen på mitt projekt var bra och jag har fått en tydlig struktur för hur man kan bygga objektorienterade program samt med MVC tänk.
Jag har även fått en bättre förståelse för hur sockets och nätverks kopplingar fungerar. 
I överlag fungerade mitt spel även fast det inte lämnade så många möjligheter för fel, strukturen behövs följas till 100% annars kan spelet lätt crasha.


## Negativa erfarenheter

Jag var för ivrig med att skapa nätverks delen. Jag borde ha skapat själva spelet först och sedan anpassat nätverksdelen efter det.
Jag hade tänkt mig göra mer saker men eftersom nätverksdelen strulade så mycket gick all min tid åt att fixa saker jag redan gjort istället för att implementera nytt.
Jag borde även ha följt min planering bättre och kanske till och med skapat ett class-diagram.

## Sammanfattning

Överlag är jag nöjd med projektet. Det fungerar även fast det finns många svagheter som skulle behövts fixas. Det finns även många andra utvecklingsmöjligheter som jag hade tänkt tillägga. Som databaskoppling större spelplaner (fyra i rad) och en view med java swing.