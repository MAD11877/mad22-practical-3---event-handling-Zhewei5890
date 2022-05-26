package sg.edu.np.mad.week3madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView icon = findViewById(R.id.imageView2);
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