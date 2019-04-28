package util;

public class Tools {

    public static int fRandomRange(int min, int max){
        int n = (int) (Math.random() * (max-min)+min);
        return n;
    }

    public static String[] fWords(){
        String[] words = {"electroencefalografista","esternocleidomastoideo","electroencefalografia","electroencefalograma","otorrinolaringologo","electrocardiograma","electrodomestico","arteriosclerosis","paralelepipedo","caleidoscopio","contrarrovolucionario","constitucionalizacion","corresponsabilizacion","interdisciplinario","pseudohermafroditismo","constantinopolitano","contramanifestacion","desconsideradamente","desoxirribonucleico","fotosensibilizadora","hispanoamericano","instrumentalizacion","fotografico","nacionalsocialismo","nacionalsindicalista","desindustrializacion","neuroendocrinologia","nacionalcatolicismo","misericordioso"};

        return words;
    }
}
