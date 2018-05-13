package com.sruly.stu.gmach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sruly.stu.gmach.logic.Operation;

import java.util.ArrayList;

/**
 * Created by stu on 5/9/2018.
 */

class HistoryForUserAdapter extends RecyclerView.Adapter<HistoryForUserAdapter.HistoryForUserVH> {
    ArrayList<Operation> operationArrayList;
    Context context;

    public HistoryForUserAdapter(ArrayList<Operation> operationsForUser, Context context) {
        this.operationArrayList = operationsForUser;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryForUserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryForUserVH(View.inflate(context, R.layout.history_for_user_rv_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryForUserVH holder, int position) {
        holder.update(operationArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return operationArrayList.size();
    }

    public class HistoryForUserVH extends RecyclerView.ViewHolder {
        TextView type, amount, sum;
        public HistoryForUserVH(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.history_for_user_rv_type);
            amount = itemView.findViewById(R.id.history_for_user_rv_amount);
            sum = itemView.findViewById(R.id.history_for_user_rv_sum);
        }

        public void update(Operation operation){
            type.setText(operation.getType());
            amount.setText("" + operation.getAmount());
            sum.setText("" + operation.getSum());
        }
    }
}
