public class CharachterList {
    private CharachterLibrary library = new CharachterLibrary();

    public CharachterList() {
        // Menambahkan CardImage ke library
        library.addCard("Image\\Kamisato Ayaka.png", "Kamisato Ayaka");
        library.addCard("Image\\Nilou.png", "Nilou");
        library.addCard("Image\\Chiori.png", "Chiori");
        library.addCard("Image\\Navia.png", "Navia");
        library.addCard("Image\\Shenhe.png", "Shenhe");
        library.addCard("Image\\Yoimiya.png", "Yoimiya");
        library.addCard("Image\\Mona.png", "Mona");
        library.addCard("Image\\Keqing.png", "Keqing");
        library.addCard("Image\\Nahida.png", "Nahida");
        library.addCard("Image\\Klee.png", "Klee");
        library.addCard("Image\\Jean.png", "Jean");
        library.addCard("Image\\Ganyu.png", "Ganyu");
        library.addCard("Image\\Hutao.png", "Hutao");
        library.addCard("Image\\Eula.png", "Eula");
        library.addCard("Image\\Furina.png", "Furina");
    }

    // Getter untuk mengakses CharachterLibrary
    public CharachterLibrary getLibrary() {
        return library;
    }
}