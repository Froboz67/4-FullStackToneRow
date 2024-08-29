import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      toneRowArray: [],
      pitchClassArray: [],
      isPitchClassVisible: false
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      setToneRowArray(state, toneRowArray) {
        state.toneRowArray = toneRowArray
      },
      setPitchClassArray(state, pitchClassArray) {
        state.pitchClassArray = pitchClassArray;
        state.isPitchClassVisible = true;
      },
      resetState(state) {
        // console.log("before reset - isPitchClassVisible:", this.$store.getIsPitchClassVisible(state));
        state.toneRowArray = [];
        state.pitchClassArray = [];
        state.isPitchClassVisible = false;
        // console.log("after reset - isPitchClassVisible:", this.$store.getIsPitchClassVisible(state));
      }
    },
    actions: {
      updateToneRowArray({ commit }, toneRowArray) {
        commit('setToneRowArray', toneRowArray)
      },
      updatePitchClassArray({ commit }, pitchClassArray) {
        commit('setPitchClassArray', pitchClassArray)
      },
      resetState({ commit }) {
        console.log("dispatching resetState");
        commit('resetState');
      },
      playSound({ commit }, pitch) {
        window.AudioContext = window.AudioContext || window.webkitAudioContext;
        const audioContext = new AudioContext();
        const oscillator = audioContext.createOscillator();
        const gainNode = audioContext.createGain();
        oscillator.connect(gainNode);
        gainNode.connect(audioContext.destination);
        oscillator.type = "sine";
        oscillator.frequency.value = pitch.frequency;
        gainNode.gain.value = 0.5;
        oscillator.start();
        oscillator.stop(audioContext.currentTime + 1.5);
        console.log("playing " + pitch.note);
      },
    },
    getters: {
      getToneRowArray(state) {
        return state.toneRowArray;
      },
      getPitchClassArray(state) {
        return state.pitchClassArray;
      },
      getIsPitchClassVisible(state) {
        return state.isPitchClassVisible;
      }
    }
  });
  return store;
}
