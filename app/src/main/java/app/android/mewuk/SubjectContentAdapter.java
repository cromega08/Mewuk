package app.android.mewuk;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public class SubjectContentAdapter extends RecyclerView.Adapter<SubjectContentAdapter.SubjectContentViewHolder> {

    private final String[] subjectContent;

    public SubjectContentAdapter(String subject, Resources resources) {
        int listID = subject.equals("numbers")? R.array.list_numbers:
                    subject.equals("family")? R.array.list_family:
                    subject.equals("colors")? R.array.list_colors:R.array.list_phrases;
        subjectContent = resources.getStringArray(listID);
    }

    @NonNull
    @NotNull
    @Override
    public SubjectContentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int contentModel = R.layout.subject_content;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachedParent = false;

        View view = inflater.inflate(contentModel, parent, attachedParent);
        return new SubjectContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SubjectContentViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return subjectContent.length;
    }

    protected class SubjectContentViewHolder extends RecyclerView.ViewHolder {
        private final TextView contentEng, contentMiw;

        public SubjectContentViewHolder(@NonNull @NotNull View view) {
            super(view);
            contentEng = view.findViewById(R.id.content_text_eng);
            contentMiw = view.findViewById(R.id.content_text_miw);
        }

        public void bind(int position) {
            String[] translations = subjectContent[position].split("~");
            contentEng.setText(translations[0]);
            contentMiw.setText(translations[1]);
        }
    }
}
