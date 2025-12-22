package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<Integer> scoreList;

    public void setScores(List<Integer> list) {
        this.scoreList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        int currentScore = scoreList.get(position);

        // 최신순 정렬 시 번호 계산
        int displayIndex = scoreList.size() - position;
        String type = (currentScore >= 14) ? "니코틴 의존" : "니코틴 비의존";

        String resultText = String.format("%d번 결과 - %d점 (%s)", displayIndex, currentScore, type);
        holder.scoreTextView.setText(resultText);
    }

    @Override
    public int getItemCount() {
        return scoreList == null ? 0 : scoreList.size();
    }

    public static class HistoryViewHolder extends RecyclerView.ViewHolder {
        public TextView scoreTextView;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            scoreTextView = itemView.findViewById(R.id.tv_score_item);
        }
    }
}
