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
      SET_TONE_ROW_ARRAY(state, toneRowArray) {
        state.toneRowArray = toneRowArray
      },
      SET_PITCH_CLASS_ARRAY(state, pitchClassArray) {
        state.pitchClassArray = pitchClassArray;
        state.isPitchClassVisible = true;
      },
      SET_MATRIX(state, matrix) {
        state.matrix = matrix;
      },
      RESET_STATE(state) {
        // console.log("before reset - isPitchClassVisible:", this.$store.getIsPitchClassVisible(state));
        state.toneRowArray = [];
        state.pitchClassArray = [];
        state.isPitchClassVisible = false;
        // console.log("after reset - isPitchClassVisible:", this.$store.getIsPitchClassVisible(state));
      }
    },
    actions: {

      updateToneRowArray({ commit }, toneRowArray) {
        commit('SET_TONE_ROW_ARRAY', toneRowArray)
      },
      updatePitchClassArray({ commit }, pitchClassArray) {
        commit('SET_PITCH_CLASS_ARRAY', pitchClassArray)
      },
      RESET_STATE({ commit }) {
        console.log("dispatching RESET_STATE");
        commit('RESET_STATE');
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
      },
      getMatrix(state) {
        return state.matrix;
      }
    }
  });
  return store;
}
