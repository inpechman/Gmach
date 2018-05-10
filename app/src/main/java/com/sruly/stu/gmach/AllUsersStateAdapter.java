package com.sruly.stu.gmach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sruly.stu.gmach.logic.User;
import com.sruly.stu.gmach.logic.UserState;

import java.util.ArrayList;

/**
 * Created by stu on 5/9/2018.
 */

class AllUsersStateAdapter extends RecyclerView.Adapter<AllUsersStateAdapter.AllUsersStateVH> {
    ArrayList<UserState> userStateArrayList;
    Context context;
    ClickTransfer clickTransfer;

    public AllUsersStateAdapter(ArrayList<UserState> userStateArrayList, Context context, ClickTransfer clickTransfer) {
        this.userStateArrayList = userStateArrayList;
        this.context = context;
        this.clickTransfer = clickTransfer;
    }

    @NonNull
    @Override
    public AllUsersStateVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllUsersStateVH(View.inflate(context, R.layout.all_users_state_rv_row, null));
    }

    @Override
    public void onBindViewHolder(@NonNull AllUsersStateVH holder, int position) {
        holder.update(userStateArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return userStateArrayList.size();
    }

    public class AllUsersStateVH extends RecyclerView.ViewHolder {
        UserState userState;
        TextView fName, lName, loanSum, depoSum;
        Button showHistory;

        public AllUsersStateVH(View itemView) {
            super(itemView);
            fName = itemView.findViewById(R.id.all_users_state_rv_first_name);
            lName = itemView.findViewById(R.id.all_users_state_rv_last_name);
            loanSum = itemView.findViewById(R.id.all_users_state_rv_loans_sum);
            depoSum = itemView.findViewById(R.id.all_users_state_rv_deposits_sum);
            showHistory = itemView.findViewById(R.id.all_users_state_rv_show_history_btn);
            showHistory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickTransfer.onClick(userState.getUser().getId());
                }
            });
        }

        public void update(UserState userState) {
            this.userState = userState;
            fName.setText(userState.getUser().getFirstName());
            lName.setText(userState.getUser().getLastName());
            loanSum.setText("" + userState.getLoanSum());
            depoSum.setText("" + userState.getDepoSum());
        }
    }

}
