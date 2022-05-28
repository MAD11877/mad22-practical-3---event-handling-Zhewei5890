package sg.edu.np.mad.week3madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView icon = findViewById(R.id.imageView2);
        Random rd = new Random();
        // Create a ArrayList storing User objects
        ArrayList<User> userList = new ArrayList<User>();
        //Use a For Loop to add 20 User objects into the ArrayLists
        for (int count = 0; count < 20; count++)
        {
            User randomUserObj = new User();
            //Randomize the respective attributes
            int randomInt =  rd.nextInt(2000000000 - 100000000);
            String randomName = Integer.toString(randomInt);
            randomUserObj.name = "Name" + randomName;
            int randomNumber =  rd.nextInt(2000000000 - 100000000);
            String randomDesc = Integer.toString(randomNumber);
            randomUserObj.description = "Description " + randomDesc;
            randomUserObj.followed = rd.nextBoolean();
            //Add User object into the ArrayList
            userList.add(randomUserObj);
        }
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder imgView = new AlertDialog.Builder(ListActivity.this);
                imgView.setTitle("Profile");
                imgView.setMessage("MADness");
                imgView.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Random random = new Random();
                        int randomNumber = random.nextInt(100000 - 10000);
                        Intent actTransfer = new Intent(ListActivity.this, MainActivity.class);
                        actTransfer.putExtra("transferInt", randomNumber);
                        startActivity(actTransfer);

                    }
                });
                imgView.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                imgView.show();
            }
        });
    }
}