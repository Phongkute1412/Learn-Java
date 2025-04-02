import React, { useEffect } from "react";
import $ from "jquery";
import "./HeaderComponent.css";
import { NavLink } from "react-router-dom";

function HeaderComponent() {
  useEffect(() => {
    function test() {
      var tabsNewAnim = $("#navbarSupportedContent");
      var activeItemNewAnim = tabsNewAnim.find(".active");
      var activeWidthNewAnimHeight = activeItemNewAnim.innerHeight() + 7;
      var activeWidthNewAnimWidth = activeItemNewAnim.innerWidth();
      var itemPosNewAnimTop = activeItemNewAnim.position();
      var itemPosNewAnimLeft = activeItemNewAnim.position();

      $(".hori-selector").css({
        top: itemPosNewAnimTop.top + "px",
        left: itemPosNewAnimLeft.left + "px",
        height: activeWidthNewAnimHeight + "px",
        width: activeWidthNewAnimWidth + "px",
      });

      $("#navbarSupportedContent").on("click", "li", function (e) {
        $("#navbarSupportedContent ul li").removeClass("active");
        $(this).addClass("active");

        var activeWidthNewAnimHeight = $(this).innerHeight() + 7;
        var activeWidthNewAnimWidth = $(this).innerWidth();
        var itemPosNewAnimTop = $(this).position();
        var itemPosNewAnimLeft = $(this).position();

        $(".hori-selector").css({
          top: itemPosNewAnimTop.top + "px",
          left: itemPosNewAnimLeft.left + "px",
          height: activeWidthNewAnimHeight + "px",
          width: activeWidthNewAnimWidth + "px",
        });
      });
    }

    $(function () {
      setTimeout(function () {
        test();
      });
    });

    $(window).on("resize", function () {
      setTimeout(function () {
        test();
      }, 500);
    });

    $(".navbar-toggler").on("click", function () {
      $(".navbar-collapse").slideToggle(300);
      setTimeout(function () {
        test();
      });
    });

    $(window).on("load", function () {
      var current = location.pathname;

      $("#navbarSupportedContent ul li a").each(function () {
        var $this = $(this);

        if (current === "/" || current === "") {
          if ($this.attr("href").indexOf("/departments") !== -1) {
            $this.parent().removeClass("active");
          }
        } else {
          if ($this.attr("href").indexOf(current) !== -1) {
            $this.parent().addClass("active");
            $this.parents(".menu-submenu").addClass("show-dropdown");
            $this.parents(".menu-submenu").parent().addClass("active");
          } else {
            $this.parent().removeClass("active");
          }
        }
      });
    });
  }, []);

  return (
    <nav className="navbar navbar-expand-custom navbar-mainbg">
      <a
        className="navbar-brand navbar-logo text-white"
        href="http://localhost:3000/"
      >
        <span>Employee</span>
        <span>Management System</span>
      </a>

      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav ml-auto">
          <div className="hori-selector">
            <div className="left"></div>
            <div className="right"></div>
          </div>

          <li className="nav-item active">
            <NavLink className="nav-link active" to="/employees">
              <i className="far fa-address-book"></i>Employees
            </NavLink>
          </li>

          <li className="nav-item">
            <NavLink className="nav-link" to="/departments">
              <i className="far fa-address-book"></i>
              Departments
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default HeaderComponent;
