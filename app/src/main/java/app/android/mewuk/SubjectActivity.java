package app.android.mewuk;

import android.content.Intent;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        String data = getIntent().getExtras().getString("subject");

        TextView subjectTitle = this.findViewById(R.id.subject_title);

        switch (data) {
            case "numbers": subjectTitle.setText(R.string.numbers); break;
            case "family": subjectTitle.setText(R.string.family);
                    subjectTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    break;
            case "colors": subjectTitle.setText(R.string.colors); break;
            case "phrases": subjectTitle.setText(R.string.phrases); break;
            default: break;
        }

        RecyclerView subjectContent = this.findViewById(R.id.subject_content);
        SubjectContentAdapter contentAdapter = new SubjectContentAdapter(data, getResources());

        subjectContent.setLayoutManager(new LinearLayoutManager(this));
        subjectContent.setHasFixedSize(true);
        subjectContent.setAdapter(contentAdapter);

        TextView backButton = this.findViewById(R.id.back);
        backButton.setOnClickListener(view -> backMain());
    }

    public void backMain() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}