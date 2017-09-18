package livedata.vb.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import livedata.vb.com.data.DataWrapper;
import livedata.vb.com.data.User;
import livedata.vb.com.livedata.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DataWrapper dataWrapper = DataWrapper.instance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleData();
    }

    private void handleData() {
        dataWrapper.setData(new User("User 1", 11));
        dataWrapper.setData(new User("User 2", 11));
        dataWrapper.setData(new User("User 3", 11));


        dataWrapper.setChangesListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User addedUser = dataSnapshot.getValue(User.class);
                l(addedUser.toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void l(String data) {
        Log.e(TAG, data);
    }
}
