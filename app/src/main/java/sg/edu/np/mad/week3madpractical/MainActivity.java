package sg.edu.np.mad.week3madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button followButton = findViewById(R.id.follow);
        Button messageButton = findViewById(R.id.message);
        TextView helloWord = findViewById(R.id.textView);

        User zheWei = new User();
        zheWei.name = "Zhe Wei";
        zheWei.description = "Week 2 Practical";
        zheWei.id = 23456;
        zheWei.followed = false;

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!zheWei.followed){
                    followButton.setText("Unfollow");
                    Toast.makeText(MainActivity.this, "Follow", Toast.LENGTH_SHORT).show();
                    zheWei.followed = true;
                }
                else{
                    followButton.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollow", Toast.LENGTH_SHORT).show();
                    zheWei.followed = false;
                }
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(mainActivity);
            }
        });

        Intent receiver = getIntent();
        int receivedInt = receiver.getIntExtra("transferInt", 0);
        helloWord.setText("MAD " + Integer.toString(receivedInt));



    }




}