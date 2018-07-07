package lakkarasu.geetha.stateslistproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.StateViewHolder> {

    public interface ListItemClickListener{
        void onListItemClick(int position);
    }

    private String[] state;
    ListItemClickListener itemClickListener;

    public Adapter(String[] stateLists,ListItemClickListener itemClickListener) {

        this.state = stateLists;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Boolean attachViewImmediatelyToParent = false;
        View singleItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,attachViewImmediatelyToParent);
        StateViewHolder myViewHolder = new StateViewHolder(singleItemLayout);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.StateViewHolder holder, int position) {
        holder.textToShow.setText(state[position]);
    }

    @Override
    public int getItemCount() {
        return state.length;
    }

    public class StateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textToShow;


        public StateViewHolder(View itemView) {
            super(itemView);
            textToShow = (TextView) itemView.findViewById(R.id.text_view);
            textToShow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onListItemClick(getAdapterPosition());
        }
    }
}