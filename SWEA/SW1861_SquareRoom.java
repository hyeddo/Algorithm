package com.ssafy.algo.algo0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SW1861_SquareRoom {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int[][] map;
    private static int N;
    private static boolean[][] visited;
    private static int max;
    private static int cnt;
    private static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "4\n" +
                "8\n" +
                "38 39 40 41 42 43 44 45 \n" +
                "46 47 48 49 50 51 52 53 \n" +
                "54 55 56 57 58 59 60 61 \n" +
                "62 63 64 1 2 3 4 5 \n" +
                "6 7 8 9 10 11 12 13 \n" +
                "14 15 16 17 18 19 20 21 \n" +
                "22 23 24 25 26 27 28 29 \n" +
                "30 31 32 33 34 35 36 37 \n" +
                "4\n" +
                "13 2 14 12 \n" +
                "10 16 6 5 \n" +
                "1 8 3 15 \n" +
                "7 11 4 9 \n" +
                "21\n" +
                "53 423 76 204 251 65 119 27 42 122 277 55 195 256 422 112 30 398 341 144 332 \n" +
                "381 32 19 264 56 286 300 401 213 342 238 135 68 91 161 345 280 416 102 75 392 \n" +
                "299 202 13 336 194 151 133 38 255 158 231 138 236 153 417 335 113 369 134 374 237 \n" +
                "263 80 44 294 377 99 21 1 273 162 327 233 436 252 291 404 104 430 421 433 437 \n" +
                "413 386 399 8 346 159 107 275 61 47 177 397 370 28 176 337 230 358 427 268 130 \n" +
                "424 141 4 408 292 174 200 250 221 324 79 160 311 308 334 396 143 126 90 179 258 \n" +
                "267 321 96 89 287 415 389 439 167 245 431 426 105 353 11 82 356 362 175 123 243 \n" +
                "239 425 40 106 152 16 328 7 272 2 246 136 365 137 241 281 298 70 379 34 293 \n" +
                "383 348 390 97 411 368 214 440 198 350 193 172 31 132 247 223 154 29 139 88 228 \n" +
                "288 432 351 95 312 414 15 261 227 12 265 319 285 186 269 52 58 5 352 235 309 \n" +
                "170 248 117 361 222 156 81 115 64 93 393 340 180 366 373 284 278 142 304 320 441 \n" +
                "23 318 171 376 354 212 17 60 290 148 110 419 74 403 147 405 124 310 114 391 39 \n" +
                "367 271 182 92 49 326 262 317 199 191 347 349 57 218 339 86 18 98 307 189 384 \n" +
                "303 313 125 87 201 51 24 163 270 325 224 207 25 6 282 120 77 279 338 190 306 \n" +
                "208 10 146 45 118 129 216 322 301 314 378 428 59 344 375 217 67 225 360 36 382 \n" +
                "197 364 412 145 438 372 406 363 380 78 429 181 165 400 296 128 330 435 140 100 407 \n" +
                "249 242 206 187 54 20 385 66 48 229 41 183 210 331 329 101 297 46 111 205 62 \n" +
                "420 359 395 253 295 69 155 103 72 333 84 244 215 388 121 323 150 305 73 357 394 \n" +
                "343 164 108 371 240 185 188 63 274 259 192 434 232 266 26 35 149 166 43 260 276 \n" +
                "168 33 289 226 85 410 315 196 409 22 302 203 116 50 71 316 219 211 402 37 83 \n" +
                "234 220 169 109 184 131 387 14 9 178 355 254 127 94 209 418 283 257 157 3 173 \n" +
                "5\n" +
                "20 21 22 23 24 \n" +
                "25 1 2 3 4 \n" +
                "5 6 7 8 9 \n" +
                "10 11 12 13 14 \n" +
                "15 16 17 18 19 \n";
        in = new BufferedReader(new StringReader(str));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            start = 0;
            max = 0;
            for (int i = 0; i < N; i++) {
                String[] s = in.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    cnt = 0;
                    dfs(i, j);
                    if (max < cnt) {
                        max = cnt;
                        start = map[i][j];
                    } else if (max == cnt) {
                        if (start > map[i][j])
                            start = map[i][j];
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(start).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        cnt++;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];
            if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC] && map[nextR][nextC] == map[r][c] + 1) {
                dfs(nextR, nextC);
            }
        }
    }
}
