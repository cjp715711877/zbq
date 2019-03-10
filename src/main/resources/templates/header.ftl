<header id="header" class="header">
    <div class="top-left">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">Zbq</a>
            <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
        </div>
    </div>
    <div class="top-right">
        <div class="header-menu">
            <div class="header-left">
                <button class="search-trigger"><i class="fa fa-search"></i></button>
                <div class="form-inline">
                    <form class="search-form">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search ..."
                               aria-label="Search">
                        <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                    </form>
                </div>


                <div class="dropdown for-message" id="unread">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="message"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-envelope"></i>
                        <span class="count bg-primary">{{unreadCount}}</span>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="message">
                        <p class="red">你有 {{unreadCount}} 条新消息</p>
                        <div v-for="unread in unreadMessageList">
                            <a class="dropdown-item media" :href="'/chat/' + unread.fromUserId">
                                <span class="photo media-left "><img alt="avatar" :src="unread.fromUserInfo.profile"></span>
                                <div class="message media-body">
                                    <span class="name float-left">{{unread.fromUserInfo.nickName}}</span>
                                    <span class="time float-right">{{unread.sendTime}}</span>
                                    <p>{{unread.newestMsg}}</p>
                                </div>
                            </a>
                        </div>

                    </div>
                </div>
            </div>

            <div class="user-area dropdown float-right">
                <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">
                    <img class="user-avatar rounded-circle" :src="profile" alt="User Avatar">
                </a>

                <div class="user-menu dropdown-menu">
                    <a class="nav-link" href="#"><i class="fa fa- user"></i>My Profile</a>

                    <a class="nav-link" href="#"><i class="fa fa- user"></i>Notifications <span
                            class="count">13</span></a>

                    <a class="nav-link" href="#"><i class="fa fa -cog"></i>Settings</a>

                    <a class="nav-link" href="#"><i class="fa fa-power -off"></i>Logout</a>
                </div>
            </div>

        </div>
    </div>
</header>