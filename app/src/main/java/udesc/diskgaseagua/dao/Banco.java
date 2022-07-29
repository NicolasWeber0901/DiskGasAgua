package udesc.diskgaseagua.dao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Banco {

    private static FirebaseFirestore db;
    private static FirebaseUser user;

    public static FirebaseFirestore getDb() {

        db = FirebaseFirestore.getInstance();
        return db;

    }

    public static FirebaseUser getUser(){

        user = FirebaseAuth.getInstance().getCurrentUser();
        return user;

    }
}
