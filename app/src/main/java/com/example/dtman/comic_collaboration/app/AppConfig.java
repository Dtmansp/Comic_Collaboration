/*
 * Copyright (C) 2016 gcideas, llc all rights reserved.
 *
 * Licensed under the general gcideas game license.
 *
 *      http://gcideas.com/licenses/GAME_LICENSE
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dtman.comic_collaboration.app;

/**
 * Created by Gene on 1/23/2016.
 */
public class AppConfig {

    /**Value - {@value}, string for storing the games.gcideas' base URL. */
    public static String GCI_GAMES_URL = "http://games.gcideas.com/cc/";

    // Server user login url
    public static String URL_LOGIN = GCI_GAMES_URL + "api/login.php";

    // Server user register url
    public static String URL_REGISTER = GCI_GAMES_URL +"api/register.php";
}
