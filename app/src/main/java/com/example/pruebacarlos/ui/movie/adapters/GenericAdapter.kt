package com.example.pruebacarlos.ui.movie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebacarlos.core.BaseConcatHolder
import com.example.pruebacarlos.databinding.NowPlayingMovieRowBinding
import com.example.pruebacarlos.databinding.PopularMovieRowBinding
import com.example.pruebacarlos.databinding.TopRatedMoviesRowBinding

enum class TypeAdapter { POPULAR, TOP_RATED, NOW_PLAYING }

class GenericAdapter(private val moviesAdapter: MoviesListAdapter, private val type: TypeAdapter) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {

        return when (type) {
            TypeAdapter.POPULAR -> {
                val itemBinding =
                    PopularMovieRowBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                PopularMovieViewHolder(itemBinding)
            }
            TypeAdapter.TOP_RATED -> {
                val itemBinding =
                    TopRatedMoviesRowBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                TopRatedViewHolder(itemBinding)
            }
            TypeAdapter.NOW_PLAYING -> {
                val itemBinding =
                    NowPlayingMovieRowBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                NowPlayingViewHolder(itemBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is PopularMovieViewHolder -> holder.bind(moviesAdapter)
            is TopRatedViewHolder -> holder.bind(moviesAdapter)
            is NowPlayingViewHolder -> holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount() = 1

    private inner class PopularMovieViewHolder(val binding: PopularMovieRowBinding) :
        BaseConcatHolder<MoviesListAdapter>(binding.root) {
        override fun bind(adapter: MoviesListAdapter) {
            binding.rvPopularMovies.adapter = adapter
        }

    }

    private inner class TopRatedViewHolder(val binding: TopRatedMoviesRowBinding) :
        BaseConcatHolder<MoviesListAdapter>(binding.root) {
        override fun bind(adapter: MoviesListAdapter) {
            binding.rvTopRatedMovies.adapter = adapter
        }
    }

    private inner class NowPlayingViewHolder(val binding: NowPlayingMovieRowBinding) :
        BaseConcatHolder<MoviesListAdapter>(binding.root) {
        override fun bind(adapter: MoviesListAdapter) {
            binding.rvNowPlayingMovies.adapter = adapter
        }
    }

}