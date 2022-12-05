package app.android.mewuk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout numbers = findViewById(R.id.numbers),
                        family = findViewById(R.id.family),
                        colors = findViewById(R.id.colors),
                        phrases = findViewById(R.id.phrases);

        numbers.setOnClickListener(view -> openSubject("numbers"));
        family.setOnClickListener(view -> openSubject("family"));
        colors.setOnClickListener(view -> openSubject("colors"));
        phrases.setOnClickListener(view -> openSubject("phrases"));
    }

    private void openSubject(String subject) {
        Intent subjectActivity = new Intent(this, SubjectActivity.class);
        subjectActivity.putExtra("subject", subject);
        startActivity(subjectActivity);
    }
}