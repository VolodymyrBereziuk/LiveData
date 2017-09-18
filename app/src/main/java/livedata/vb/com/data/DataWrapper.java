package livedata.vb.com.data;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataWrapper {

    private static DataWrapper mDataWrapper = null;
    private FirebaseDatabase database = null;
    private DatabaseReference mReference;

    public static DataWrapper instance() {
        if (mDataWrapper == null) {
            mDataWrapper = new DataWrapper();
        }
        return mDataWrapper;
    }

    private DataWrapper() {
        database = FirebaseDatabase.getInstance();
        mReference = database.getReference().child("message");
    }

    public void setData(User data) {
        mReference.push().setValue(data);
    }

    public void setChangesListener(ChildEventListener listener) {
        mReference.addChildEventListener(listener);
    }


}
