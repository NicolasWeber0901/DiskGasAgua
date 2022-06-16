package udesc.diskgaseagua.dao;

import com.google.firebase.firestore.FirebaseFirestore;

public class Banco {

    private static FirebaseFirestore db;

    public static FirebaseFirestore getDb() {

        db = FirebaseFirestore.getInstance();
        return db;

    }
}
