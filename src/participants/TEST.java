package participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.participants.Participant;

public class TEST {
    public static void main(String[] args) {

        Contact cont0 = new ContactImp("Rua Doutor Joaquim Manuel Costa 194", "Gondomar", "Porto", "4420-437", "913844167", "Portugal");
        Contact cont1 = new ContactImp("Rua Ramalade", "Felgueiras", "Porto", "1212-212", "Portugal", "999999999");
        Contact cont2 = new ContactImp("Avenida Salma", "Felgueiras", "Porto", "1312-112", "Portugal", "999993837");
        Contact cont3 = new ContactImp("Rua Delta", "Felgueiras", "Porto", "4230-200", "Portugal", "89323837");
        Contact cont4 = new ContactImp("Rua Chaunatau", "Felgueiras", "Porto", "4230-123", "Portugal", "982654321");
        Contact cont5 = new ContactImp("Praça Comunidades", "Felgueiras", "Porto", "4230-190", "Portugal", "982654321");
        Contact cont6 = new ContactImp("Avenida Dalai Lama", "Porto", "Porto", "4270-123", "Portugal", "982654321");
        Contact cont7 = new ContactImp("Rua Compadres", "Porto", "Porto", "4270-131", "Portugal", "982654321");
        Contact cont8 = new ContactImp("Rua Gildiniz", "Porto", "Porto", "4270-190", "Portugal", "982654321");
        Contact cont9 = new ContactImp("Praça Folha Boa", "Porto", "Porto", "4270-123", "Portugal", "999993837");
        Contact cont10 = new ContactImp("Ruas Neto", "Porto", "Porto", "4270-111", "Portugal", "999993837");
        Contact cont11 = new ContactImp("Condomino Laura", "Porto", "Porto", "-", "Portugal", "92333837");
        Contact cont12 = new ContactImp("Rua Dinarca", "Porto", "Porto", "4370-111", "Portugal", "92213837");
        Contact cont13 = new ContactImp("Rua Ponhce Caule", "Porto", "Porto", "4170-121", "Portugal", "92311837");

        Instituition i1 = new InstitutionImp("ESTG", cont1, "sa@estg.ipp.pt", InstituitionType.UNIVERSITY, "Escola Superior de Tecnologia e Gestão", "www.estg.ipp.pt");


        Participant p1 = new StudentImp("Pedro Teixeira", "jpedroteixeira59@gmail.com", cont0, i1, 8200489);

        System.out.println(p1.toString());
    }
}
