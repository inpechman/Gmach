package com.sruly.stu.gmach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sruly.stu.gmach.logic.Operation;

import java.util.ArrayList;

/**
 * Created by stu on 5/9/2018.
 */

class HistoryForUserAdapter extends RecyclerView.Adapter<HistoryForUserVH> {

    public HistoryForUserAdapter(ArrayList<Operation> operationsForUser, Context context) {

    }

    @NonNull
    @Override
    public HistoryForUserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryForUserVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
