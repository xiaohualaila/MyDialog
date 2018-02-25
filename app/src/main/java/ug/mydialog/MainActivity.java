package ug.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        final VersionDialogFragment dialogFragment = VersionDialogFragment.getInstance("2.0.1新版本发布啦", "更多功能等你体验");
        dialogFragment.show(getSupportFragmentManager(), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "进行更新操作吧", Toast.LENGTH_SHORT).show();
                        dialogFragment.dismiss();
                    }
                });

    }


}
