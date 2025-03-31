import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { defineNuxtPlugin } from "nuxt/app";
import {
  faHome,
  faUser,
  faTimes,
  faDesktop,
  faMugSaucer,
  faUsers,
  faBuilding,
  faUserCircle,
  faPenToSquare,
  faTrash,
  faPlus,
  faChevronLeft,
  faChevronRight,
  faSortDown,
  faSortUp,
  faRightFromBracket,
  faSort,
  faForwardStep,
  faBackwardStep,
  faPlay,
  faRotateRight,
  faCheck,
  faEye,
  faExclamationTriangle,
  faInfoCircle,
  faClock,
  faCalendar

} from "@fortawesome/free-solid-svg-icons";
import {
  faGoogleDrive
} from "@fortawesome/free-brands-svg-icons";
export default defineNuxtPlugin((nuxtApp) => {
  library.add(
    faHome, faUser, faTimes, faDesktop, faMugSaucer, faUsers, faBuilding, faUserCircle,
    faPenToSquare, faTrash, faPlus, faChevronLeft, faChevronRight, faSortDown, faSortUp,
    faRightFromBracket, faSort, faForwardStep, faBackwardStep, faPlay, faRotateRight,
    faCheck, faEye, faExclamationTriangle, faInfoCircle, faClock, faCalendar,faGoogleDrive
  );
  nuxtApp.vueApp.component("FontAwesomeIcon", FontAwesomeIcon);
});
